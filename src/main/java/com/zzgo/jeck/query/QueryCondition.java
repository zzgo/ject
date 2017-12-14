package com.zzgo.jeck.query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class QueryCondition<T> implements Specification<T> {

    // 查询条件容器

    private List<Criterion> criterions = new ArrayList<Criterion>();
    // 倒序查询条件
    private String orderByDESC;
    // 升序查询条件
    private String orderByASC;
    // group查询条件
    private String groupBy;

    //使用and 或者是or
    private boolean and = false;
    private boolean or = false;

    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (!StringUtils.isEmpty(orderByASC))
            query.orderBy(builder.asc(root.get(getOrderByASC())));
        if (!StringUtils.isEmpty(orderByDESC))
            query.orderBy(builder.desc(root.get(getOrderByDESC())));
        if (!StringUtils.isEmpty(groupBy))
            query.groupBy(root.get(getGroupBy()));
        if (!criterions.isEmpty()) {
            List<Predicate> predicates = new ArrayList<Predicate>();
            for (Criterion c : criterions) {
                predicates.add(c.toPredicate(root, query, builder));
            }
            if (and) {
                if (predicates.size() > 0) {
                    return builder.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            } else if (or) {
                if (predicates.size() > 0) {
                    return builder.or(predicates.toArray(new Predicate[predicates.size()]));
                }
            } else {
                if (predicates.size() > 0) {
                    return builder.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            }
        }
        return builder.conjunction();
    }

    /**
     * 增加简单条件表达式
     *
     * @Methods Name add
     */
    public void add(Criterion criterion) {
        if (criterion != null) {
            criterions.add(criterion);
        }
    }

    public List<Criterion> getCriterions() {
        return criterions;
    }

    public void setCriterions(List<Criterion> criterions) {
        this.criterions = criterions;
    }

    public boolean isAnd() {
        return and;
    }

    public void setAnd(boolean and) {
        this.and = and;
    }

    public boolean isOr() {
        return or;
    }

    public void setOr(boolean or) {
        this.or = or;
    }

    public void orderByDESC(String col) {
        setOrderByDESC(col);
    }

    public void orderByASC(String col) {
        setOrderByASC(col);
    }

    public void groupBy(String col) {
        setGroupBy(col);
    }

    public String getOrderByDESC() {
        return orderByDESC;
    }

    private void setOrderByDESC(String orderByDESC) {
        this.orderByDESC = orderByDESC;
    }

    public String getOrderByASC() {
        return orderByASC;
    }

    private void setOrderByASC(String orderByASC) {
        this.orderByASC = orderByASC;
    }

    public String getGroupBy() {
        return groupBy;
    }

    private void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    /**
     * 是否存在查询条件
     *
     * @return
     */
    public boolean exitCondition() {
        if (criterions.size() > 0) {
            return true;
        }
        return false;

    }

}
