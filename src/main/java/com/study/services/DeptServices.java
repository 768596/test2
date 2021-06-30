package com.study.services;

import com.study.model.dao.DeptDAO;
import com.study.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/*
 * @author SMILE.Huang
 * @date 2021-05-13 15:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeptServices {
    /*自动注入*/
    @Autowired
    private DeptDAO dao;

    /**新增和修改
     * @param dept 带新增的部门实体类
     * @return
     */
    public Integer doUpdate(Dept dept){
        //主键自动生成之后，能够注入到实体类中，需要在实体类的主键字段上添加
        // @GeneratedValue(strategy = GenerationType.IDENTITY)
        Dept d = dao.save(dept);
        return 1;
    }

    /**根据主键获取对象
     * @param did 主键编号
     * @return
     */
    public Dept findById(Integer did){
        Optional<Dept> op = dao.findById(did);
        if(op.isPresent())
            return op.get();
        return null;
    }

    public List<Dept> findByDname(String dnamd){
        return dao.findByDname(dnamd);
    }

    /**分页查询
     * @param keyword 查询的关键字
     * @param pageNo  分页的页码
     * @param pageSize 分页的数量
     * @return
     */
    public List<Dept> selectByKeyWord(String keyword,Integer pageNo,Integer pageSize){
        Sort.Direction direction = Sort.Direction.DESC;/*排序方式*/
        PageRequest pager = PageRequest.of(pageNo-1,pageSize,
                direction,"deptno");/*主键排序*/
        return dao.selectByKeyWord(keyword,pager);
    }



}
