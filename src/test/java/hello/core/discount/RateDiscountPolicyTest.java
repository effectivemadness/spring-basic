package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인 적용되어야 함")
    void vip_o() {
        Member member = new Member(1L, "MemberVIP", Grade.VIP);

        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertEquals(1000, discount);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용되지 않아야 함")
    void vip_x() {
        Member member = new Member(1L, "MemberBASIC", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertEquals(0, discount);
    }

}