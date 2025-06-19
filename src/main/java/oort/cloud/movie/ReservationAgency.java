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
        MovieData movie = screeningData.getMovie();

        boolean discountable = false;
        // 새로운 할인 정책을 추가해야 할 경우
        // DiscountCondition 검증 해야하는 로직 추가 필요
        for (DiscountCondition condition : movie.getDiscountConditions()) {
            if(condition.getType() == DiscountConditionType.PERIOD){
                discountable = screeningData.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek())
                                && screeningData.getWhenScreened().toLocalTime().isAfter(condition.getStartTime())
                                && screeningData.getWhenScreened().toLocalTime().isBefore(condition.getEndTime());
            }else{
                discountable = screeningData.getSequence() == condition.getSequence();
            }

            if(discountable) break;
        }

        Money fee;

        if(discountable){
            Money discountAmount = Money.ZERO;
            //새로운 할인 정책이 추가될 경우
            //새로운 분기 로직이 필요하며 Movie 객체에 데이터도 변경이 필요함
            switch (movie.getMovieType()){
                case PERCENT_DISCOUNT -> discountAmount = movie.getFee().times(movie.getDiscountPercent());
                case AMOUNT_DISCOUNT -> discountAmount = movie.getDiscountAmount();
            }

            fee = movie.getFee().minus(discountAmount);
        }else{
            fee = movie.getFee();
        }


        return new ReservationData(customer, screeningData, fee, audienceCount);
    }
}
