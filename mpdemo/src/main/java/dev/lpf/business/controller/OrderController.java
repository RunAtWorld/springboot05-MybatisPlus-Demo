package dev.lpf.business.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.lpf.business.service.IOrderService;
import dev.lpf.business.entity.Order;
import dev.utils.PageUtils;
import dev.utils.R;




/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author RunAtWorld
 * @since 2020-05-28
 */
@RestController
@RequestMapping("/business/order")
public class OrderController {
    @Autowired
    private IOrderService entityService;

    /**
     *  列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entityService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 根据id获取 
     */
    @GetMapping("/id/{id}")
    public R getById(@PathVariable("id") String id) {
        return R.ok().put("data", entityService.getById(id));
    }

    /**
     * 所有 
     */
    @GetMapping("/all")
    public R getAll() {
        return R.ok().put("data", entityService.list());
    }

    /**
     *  保存
     */
    @PostMapping("/save")
    public R save(@RequestBody Order entity){
        boolean ok = entityService.save(entity);
        if (ok) {
            return R.ok();
        }
        return R.error();
    }

    /**
     *  修改
     */
    @PutMapping("/update")
    public R update(@RequestBody Order entity){
        boolean ok = entityService.updateById(entity);

        if (ok) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 根据 id数组 删除   删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
    entityService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 根据 id 删除 
     */
    @DeleteMapping("/delete/{id}")
    public R delById(@PathVariable("id") String id) {
        boolean ok = entityService.removeById(id);
        if (ok) {
            return R.ok();
        }
        return R.error();
    }

}
