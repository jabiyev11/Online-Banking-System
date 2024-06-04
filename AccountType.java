import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public enum AccountType {

    SAVINGS, CHECKING, BUSINESS;

    public List<CardType> getSuggestedCardTypes(){
        switch(this){
            case SAVINGS:
                return Arrays.asList(CardType.CREDIT, CardType.DEBIT);
            case CHECKING:
                return Arrays.asList(CardType.DEBIT, CardType.CREDIT, CardType.PREPAID);
            case BUSINESS:
                return Arrays.asList(CardType.CREDIT);
            default:
                return Collections.emptyList();
        }
    }
}
