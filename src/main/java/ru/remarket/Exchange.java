package ru.remarket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HEDIN on 01.11.2017.
 */
public class Exchange {
    private Map<String, Instrument> instruments = new HashMap<String, Instrument>();
    private Map<String, Glass> glasses = new HashMap<String, Glass>();

    private void newInstrument(Instrument instrument){
        instruments.put(instrument.getName(), instrument);
        glasses.put(instrument.getName(), new Glass());
    }
}
