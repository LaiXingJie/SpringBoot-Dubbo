package com.thunder.service.imp;

import com.thunder.dao.mapper.PetMapper;
import com.thunder.pojo.Pet;
import com.thunder.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Think
 */
@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetMapper petMapper;

    /**
     * 注入一个springboot自动配置好的RedisTemplate
     */
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public /*synchronized*/ List<Pet> getAllPet() {

        //字符串的序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        //设置redis生成字符串的序列化
        redisTemplate.setKeySerializer(redisSerializer);

        //高并发条件下,此处会有问题，会产生缓存穿透，可以加一个同步锁synchronized
        //若是缓存有数据则赋值给allPet
        List<Pet> allPet =(List<Pet>)redisTemplate.opsForValue().get("allPet");

        //双重检测锁，避免缓存穿透
        if (null == allPet){
            //放一个进来，其他的等待
            synchronized (this){

                //再从redis获取一下
               allPet =(List<Pet>)redisTemplate.opsForValue().get("allPet");

                if (null == allPet){

                    System.out.println("查询的数据库......");
                    //缓存为空，查询数据库
                    allPet = petMapper.selectAllPet();
                    //把查出来的数据，放入redis中
                    redisTemplate.opsForValue().set("allPet",allPet);
                }else {
                    System.out.println("查询的缓存....");
                }
            }
        }else {
            System.out.println("查询了缓存......");
        }

        return allPet;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update() {

        int i = 0;
        Pet pet = new Pet();
        pet.setPetid(15L);
        pet.setPetname("猪猪侠-update");
        i = petMapper.updateByPrimaryKey(pet);
        System.out.println("更新了：" + i);

        //制造一个异常测试事务是否有回滚的功能
        int a= 1/0;

        return i;
    }
}
