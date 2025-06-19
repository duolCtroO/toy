package oort.cloud.movie.domain.data;

import oort.cloud.movie.domain.Customer;
import oort.cloud.movie.domain.Money;

public class ReservationData {
    private Customer customer;
    private ScreeningData screening;
    private Money money;
    private int audienceCount;

    public ReservationData(Customer customer, ScreeningData screening, Money money, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.money = money;
        this.audienceCount = audienceCount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ScreeningData getScreening() {
        return screening;
    }

    public void setScreening(ScreeningData screening) {
        this.screening = screening;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public int getAudienceCount() {
        return audienceCount;
    }

    public void setAudienceCount(int audienceCount) {
        this.audienceCount = audienceCount;
    }
}
