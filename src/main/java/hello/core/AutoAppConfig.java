package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * packageName    : hello.core
 * fileName       : AutoAppConfig
 * author         : Jihun Park
 * date           : 2022/03/02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/03/02        Jihun Park       최초 생성
 */
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // 예제를 위해 @Configuration 달린 클래스는 스캔에서 제외
public class AutoAppConfig {
//    @Bean(name = "memoryMemberRepository")  // 같은이름으로 중복되는 수동 Bean이 자동 Bean을 오버라이드함!!( 기본값은 false)
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
