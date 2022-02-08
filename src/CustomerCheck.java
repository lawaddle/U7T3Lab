
import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double total = 0;
        for (MenuItem items: check) {
            total += items.getPrice();
        }
        return total;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        for (MenuItem item: check) {
            if (item.isDailySpecial())
            {
                return false;
            }
        }
        if (totalPrices() < 40)
        {
            return false;
        }
        return true;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        double origMon = totalPrices();
        double subDiscount = 0;
        double addTip = 0;
        if (couponApplies())
        {
            subDiscount = .25*origMon;
        }
        int customers = 0;
        for (MenuItem ite: check) {
            if (ite.isEntree())
            {
                customers++;
            }
        }
        if (customers >= 6)
        {
            addTip = .2*origMon;
        }
        return origMon + addTip - subDiscount;

    }
}