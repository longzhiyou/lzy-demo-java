package lzy.module.customer.resource;

import lzy.common.CommonDefine;
import lzy.module.customer.entity.Customer;
import lzy.module.customer.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * User: longzhiyou
 * Date: 2019/1/14
 * Time: 17:57
 */
@RestController
@RequestMapping(value = CommonDefine.BASE_URI+"/customers")
public class CustomerResource {

    Logger logger = LoggerFactory.getLogger(CustomerResource.class);

    //先使用repository
    @Autowired
    CustomerRepository customerRepository;

    /**
     * 获取资源列表
     * @return
     */
    @GetMapping()
    public ResponseEntity index() {

        return new ResponseEntity(HttpStatus.OK);

    }

    /**
     * 获取一个资源
     * @param id
     * @return
     */
    @GetMapping(value ="/{id}")
    public ResponseEntity show(@PathVariable Long id) {
        Customer one = customerRepository.findOne(id);
        if (one==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(one, HttpStatus.OK);
        }

    }

    /**
     * 创建一个资源
     * @param create
     * @return
     */
    @PostMapping(consumes = "application/json")
    public ResponseEntity create(@RequestBody Customer create) {


        Customer save = customerRepository.save(create);

        return new ResponseEntity<>(save, HttpStatus.CREATED);


    }

    /**
     * 版本2
     * @param create
     * @return
     */
    @PostMapping(consumes = "application/json",headers = {"X-API-Version=2"})
    public ResponseEntity createV2(@RequestBody Customer create) {

        Customer save = customerRepository.save(create);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }


    @PutMapping(value ="/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Customer update) {
        Customer one = customerRepository.findOne(id);
        if (one==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            //拷贝
//            BeanCopyUtil.copyPropertiesIgnoreNull(update, one);
            customerRepository.save(one);
            return new ResponseEntity<>(one, HttpStatus.OK);
        }

    }


    @DeleteMapping(value ="/{id}")
    public ResponseEntity destroy(@PathVariable Long id) {
        Customer one = customerRepository.findOne(id);
        if (one==null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }else {
            customerRepository.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }



    }

}
