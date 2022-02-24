package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Member member1 = new Member();
            member1.setName("AAA");
            Member member2 = new Member();
            member2.setName("BBB");
            Member member3 = new Member();
            member3.setName("CCC");
            System.out.println("-----------------------------");

//            em.persist(member); //persist를 호출한 시점에 insert 쿼리를 날린다.
//            SEQUENCES 전략일 경우 영속성 컨텍스트에 pk값이 저장되어있어야 하기 때문에 시퀀스를 먼저 불러온다. 따라서 결과 콘솔창을 보면 em.persist(member)에서 call next value for MEMBER_SEQ가 호출되어지는것을 알 수 있다.
//            System.out.println("member.id:"+member.getId()); //id값을 가져오는것을 확인, AUTO_INCREMENT는 데이터베이스에 INSERT SQL을 실행한 이후에 ID값을 알 수 있음

//           DB SEQ = 1 | 1
//           DB SEQ = 51 | 2
//           DB SEQ = 51 | 3
            em.persist(member1); //1, 51
            em.persist(member2); //MEM 호출
            em.persist(member3); //MEM 호출
            System.out.println("member1:"+member1.getId());
            System.out.println("member2:"+member2.getId());
            System.out.println("member3:"+member3.getId());
            System.out.println("-----------------------------");


            tx.commit();
//        트랜잭션을 커밋할때 쿼리가 날라간다. 이때 쿼리가 콘솔창에 찍히게 되는것이다.
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();





    }


}
