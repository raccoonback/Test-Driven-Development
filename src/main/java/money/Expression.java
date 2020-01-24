package money;

/**
 * Created by koseungbin on 2020-01-23
 */

public interface Expression {
    Money reduce(Bank bank, String to);

}
