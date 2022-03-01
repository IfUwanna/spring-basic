package hello.core.beanfind;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : hello.core.beanfind
 * fileName       : ApplicationContextSameBeanFindTest
 * author         : Jihun Park
 * date           : 2022/03/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/03/01        Jihun Park       최초 생성
 */
public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    /*
    ac.getBean("memberService", MemberService.class);  //이름으로 조회
    ac.getBean(MemberService.class); //클래스 타입만 가지고 조회 가능
    ac.getBean("memberService", MemberServiceImpl.class); // 동적 인스턴스 타입으로 조회
    ac.getBean(MemberRepository.class); // 타입 조회시 동일타입 Bean 둘 이상이면 오류
    ac.getBean("memberRepository1", MemberRepository.class); //이름 명시하여 해결
    Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class); // 특정타입 모두 조회
    * */

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류 발생")
    void findBeanByTypeDuplicate() {
        MemberRepository bean = ac.getBean(MemberRepository.class);
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    void findBeanByName() {
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }


    @Test
    @DisplayName("특정 타입을 모두 조회하기")  // getBeansOfType() 으로 동일타입 조회
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }


    @Configuration
    static class SameBeanConfig{  // MemoryMemberRepository 타입으로 동일한 두개의 Bean이 등록됨
       @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
