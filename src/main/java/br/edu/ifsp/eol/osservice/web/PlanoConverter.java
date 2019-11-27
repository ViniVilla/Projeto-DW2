package br.edu.ifsp.eol.osservice.web;

import br.edu.ifsp.eol.osservice.modelo.Plano;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlanoConverter implements Converter<String, Plano> {

    @Override
    public Plano convert(String source) {
        switch (source){
            case "Monofasico":
                return Plano.MONO;
            case "Bifasico":
                return Plano.BI;
            case "Trifasico":
                return Plano.TRI;
            default:
                return null;
        }
    }
}
