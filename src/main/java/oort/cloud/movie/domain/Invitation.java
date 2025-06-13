package oort.cloud.movie.domain;

import java.time.LocalDate;

public class Invitation {
    private final int invitationId;
    private final LocalDate invitationDate;

    public Invitation(int invitationId, LocalDate invitationDate) {
        this.invitationId = invitationId;
        this.invitationDate = invitationDate;
    }

    public int getInvitationId() {
        return invitationId;
    }

    public LocalDate getInvitationDate() {
        return invitationDate;
    }

    @Override
    public String toString() {
        return "Invitation{" +
                "invitationId=" + invitationId +
                ", invitationDate=" + invitationDate +
                '}';
    }
}
