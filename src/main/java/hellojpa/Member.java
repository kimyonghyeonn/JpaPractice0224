package hellojpa;



import javax.persistence.*;

@Entity
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR", //식별자 생성기 이름
//        table = "MY_SEQUENCES", // 키 생성 테이블 명
//        pkColumnValue = "MEMBER_SEQ", //키로 사용할 값 이름
//        allocationSize = 1 //시퀀스 한번 호출에 증가하는 수(성능 최적화에 사용, 기본값:50)
//
//)
//권장하는 식별자 전략
//기본키 제약 조건: null 아님, 유일, 변하면 안된다(핵심)
//미래까지 이 조건을 만족하는 자연키는 찾기 어렵다. 대리키(대체키)를 사용
//예를 들어 주민등록번호도 기본 키로 적절하지 않다
//권장: Long형+대체키+키 생성전략 사용
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 50
)
public class Member {

//    @GeneratedValue: auto_increment처럼 기본값을 생성해주는 어노테이션, 속성은 IDENTITY, AUTO
//    IDENTITY: 기본키 생성을 DB에 위임, 주로 MySQL,PostgreSQL, SQL Server, DB2에서 사용
//    SEQUENCE: DB 시퀀스 오브젝트 사용, ORACLE, @SequenceGenerator 필요
//    TABLE: 키 생성용 테이블 사용, 모든 DB에서 사용, @TableGenerator 필요
//    AUTO: 방언에 따라 자동 지정

//    JPA는 보통 트랜잭션 커밋 시점에 INSERT SQL 실행
//    AUTO_INCREMENT는 DB에 INSERT SQL을 실행한 이후에 ID값을 알 수 있음
//    IDENTITY전략은 em.persist()시점에 즉시 INSERT SQL을 실행하고 DB에서 식별자 조회
//
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "MEMBER_SEQ_GENERATOR")
        private Long id;

        @Column
        private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
