package com.zzgo.jeck.query;

public class TestQuery {

    /**
     * 注意此查询针对单表分页查询
     * 关联查询分表请使用jpa原生查询
     */
    public void getTObjectJson() {

        //查询事例
        //QueryCondition<Test> criteria = new QueryCondition<>();
        //criteria.add(Restrictions.eq("name", "test")); //等于 name = ‘test’
        //criteria.add(Restrictions.like("name", "test", Criterion.MatchMode.ANYWHERE)); //等于 name like %test%
        //criteria.add(Restrictions.between("age", 1 , 20));  //age between(1, 20)
        //criteria.add(Restrictions.isNotEmpty("name")); // ISNOTEMPTY(name)
        //List<String> list = new ArrayList<String>();
        //list.add("Alice");
        //list.add("Mick");
        //criteria.add(Restrictions.in("name", list));  // name in ('Alice','Mick')
        //
        //criteria.add(Restrictions.eq(Projections.Length("name"), 5));  // length(name) = 5
        //criteria.add(Restrictions.gt(Projections.Max("name"), 5));  // max(name) = 5
        //criteria.add(Restrictions.or(Restrictions.eq("name", "tt"),Restrictions.eq("name", "qq"))); //(name = 'tt'
        // or name = 'qq')
        //查询
        //List<User> userList = userRepository.findAll(criteria);
    }

    /**
     * jpa 原生分页查询
     */

	/*public Page<Test> query(final String tname,final String sex,final String degree,final String orgname) {  
		return TestDao.findAll(new Specification<EduTeachers>() {  
                 @Override  
                 publicPredicate toPredicate(Root<EduTeachers> root, CriteriaQuery<?>query, CriteriaBuilder cb) {  
                          //TODO Auto-generated method stub  
                          Path<String>namepath = root.get("name");   
                     Path<String> sexpath =root.get("sex");   
                     Path<String> degreepath =root.get("degree");   
                     List<Predicate> list = newArrayList<Predicate>();  
                    if(tname!=null&&!"".equals(tname)) {  
                              list.add(cb.like(namepath,"%"+tname+"%"));  
                     }  
                    if(sex!=null&&!"".equals(sex)) {  
                              list.add(cb.like(sexpath,"%"+sex+"%"));  
                     }  
                    if(degree!=null&&!"".equals(degree)) {  
                              list.add(cb.like(degreepath,"%"+degree+"%"));  
                     }  
                    if(orgname!=null&&!"".equals(orgname)) {  
                              Path<String>orgnamepath=root.get("org").get("orgname");  
                              list.add(cb.like(orgnamepath,"%"+orgname+"%"));  
                     }  
                     Predicate[] p = new Predicate[list.size()];  
          return cb.and(list.toArray(p)); 
                 }  
        },new PageRequest(0, 2, new Sort(Direction.DESC, "org.orgname")));  */


}
