package behavioral_patterns.chain_of_responsibility;

public class MyCOR {
    public static void main(String[] args) {
        Cash cash_1000 = new Note(15, Value.B1000);
        Cash cash_500 = new Note(20, Value.B500);
        Cash cash_200 = new Note(5, Value.B200);
        Cash cash_100 = new Note(30, Value.B100);

        cash_1000.setNextBanknote(cash_500);
        cash_500.setNextBanknote(cash_200);
        cash_200.setNextBanknote(cash_100);

        int cashes = cash_1000.countingCash(20_700);
        if(cashes > Value.MAX_NOTE) {
            System.out.println("Too many notes: " + cashes);
        } else {
            System.out.println("Amount notes: " + cashes);
        }

        System.out.println();
        int cashes2 = cash_1000.countingCash(7_800);
        if(cashes2 > Value.MAX_NOTE) {
            System.out.println("Too many notes: " + cashes2);
        } else {
            System.out.println("Amount notes: " + cashes2);
        }
    }
}

abstract class Cash {
    private Cash nextNote;
    protected int amount;
    protected int denomination;

    public Cash(int amount, int denomination) {
        this.amount = amount;
        this.denomination = denomination;
    }

    public void setNextBanknote(Cash nextNote) {
        this.nextNote= nextNote;
    }

    int countingCash(int value) {
        int count = 0;
        int whole = value / denomination;
        int remainder = value % denomination;

         if (whole > 0) {
             if (whole >= amount) {
                 remainder += (whole - amount) * denomination;
                 whole = amount;
             }
             count += whole;
             amount -= whole;
             getCash(whole);
        }

        if(remainder > 0 && nextNote != null) {
            count += nextNote.countingCash(remainder);
        }

        return count;
    }

    abstract void getCash(int whole);
}

class Value {
    public static final int B1000 = 1000;
    public static final int B500 = 500;
    public static final int B200 = 200;
    public static final int B100 = 100;

    public static final int MAX_NOTE = 40;
}

class Note extends Cash{

    public Note(int amount, int denomination) { super(amount, denomination); }

    @Override
    void getCash(int whole) {
        System.out.println("Get: " + whole + " banknotes with a bill of " + denomination + ", banknotes left: " + amount);
    }
}