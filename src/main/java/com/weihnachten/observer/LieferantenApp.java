package com.weihnachten.observer;

public class LieferantenApp implements Observer{
    @Override
    public void update(GeschenkStatus status) {
        if (status == GeschenkStatus.VERPACKT) {
            System.out.println("Super ich kann die Lieferung abholen");
        }
    }
}
