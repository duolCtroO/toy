package oort.cloud.movie;

import oort.cloud.movie.domain.*;
import oort.cloud.movie.domain.data.*;

/**
 *  데이터 중심 설계로 인한 높은 결합도
 *  ScreeningData, Movie, DiscountCondition 클래스들이 변경이 일어난다면 해당 모듈도 다 변경되야 한다.
 *  결합도가 높음
 *
 *  새로운 할인 정책을 추가해야한다면 하나 이상의 클래스를 변경해야함 이는 응집도가 낮다고 판단할 수 있음
음*/
public class ReservationAgency {
    public ReservationData reserve(ScreeningData screeningData, Customer customer, int audienceCount){
        Money money = screeningData.calculateFee(audienceCount);
        return new ReservationData(customer, screeningData, money, audienceCount);
    }
}
