package com.mmall.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author LiYingChun
 * @date 2018/11/19
 */
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    /**
     * 添加商品分类
     *
     * @param categoryName name
     * @param parentId     父节点
     * @return 提示消息
     */
    @Override
    public ServerResponse addCategory(String categoryName, Integer parentId) {
        if (parentId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMsg("参数错误");
        }

        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(parentId);
        category.setStatus(true);

        int resCou = categoryMapper.insert(category);
        if (resCou > 0) {
            return ServerResponse.createBySuccess("商品分类添加成功");
        }
        return ServerResponse.createByErrorMsg("商品分类添加失败");
    }

    /**
     * 更新分类名称
     *
     * @param categoryId   id
     * @param categoryName name
     * @return 提示信息
     */
    @Override
    public ServerResponse updateCategoryName(Integer categoryId, String categoryName) {
        if (categoryId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMsg("参数错误");
        }
        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        int rowCou = categoryMapper.updateByPrimaryKeySelective(category);
        if (rowCou > 0) {
            return ServerResponse.createBySuccess("更新分类名称成功");
        }
        return ServerResponse.createByErrorMsg("更新分类名称失败");
    }

    /**
     * 获取categoryId下的平级信息
     *
     * @param categoryId id
     * @return List形式的category信息
     */
    public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId) {
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        if (CollectionUtils.isEmpty(categoryList)) {
            // 如果列表为空，返回前端无意义，因此打印logger
            logger.info("未找到当前分类的子分类");
        }
        return ServerResponse.createBySuccess(categoryList);
    }

}
