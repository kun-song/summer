package com.satansk.summer.site.web;

import com.satansk.summer.site.domain.ApiSpec;
import com.satansk.summer.site.service.ApiManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10
 *
 * 1. @RequestMapping 使用请求路径 + 请求内容来做路由，只接受 Content-Type 为 application/json 的请求
 * 2. Angular2 GET 方法默认不会携带 Content-Type 参数，去掉 consumes 注解保证路由正确。
 */
@RestController
@RequestMapping(
        value = "api/spec",
        produces = "application/json; charset=UTF-8"
)
public class ApiSpecController {
    private static final Logger logger = LoggerFactory.getLogger(ApiSpecController.class);

    @Autowired private ApiManagerService apiManager;

    /************************************** REST 接口 ***************************************/

    /**
     * 允许使用 OPTIONS, GET, POST, PUT, DELETE 等方法。
     */
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> discover()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Allow", "OPTIONS, GET, POST, PUT, DELETE");
        return new ResponseEntity<Void>(null, headers, HttpStatus.OK);
    }

    /**
     * 保存 ApiSpec
     *
     * @param apiSpec 前端传入的 ApiSpec
     * @return 保存后的 ApiSpec
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ApiSpec> add(@RequestBody(required = true) ApiSpec apiSpec)
    {
        ApiSpec spec = apiManager.saveApiSpec(apiSpec);
        return new ResponseEntity<>(spec, HttpStatus.CREATED);
    }

    /**
     * 删除 ID 指定的 ApiSpec
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        apiManager.deleteApiSpec(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    /**
     * 修改指定 ApiSpec
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ApiSpec modify(@RequestBody ApiSpec apiSpec)
    {
        return apiManager.updateApiSpec(apiSpec);
    }

    /**
     * 获取所有 ApiSpec 列表
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ApiSpec> findAll()
    {
        return apiManager.findAllApiSpec();
    }

    /**
     * 获取 ApiSec 总数
     */
    @RequestMapping(value = "count", method = RequestMethod.GET)
    @ResponseBody
    public long count()
    {
        return apiManager.countApiSpec();
    }
}
