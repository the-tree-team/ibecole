package com.ibecole.ibecole.service.business.matGenerate;

import com.ibecole.ibecole.model.request.PersonneRequest;
import org.springframework.stereotype.Component;

/**
 * Created by TOSHIBA on 12/12/2018.
 */
@Component
public interface  MatriculeGenerate {
public  String Generate (PersonneRequest personneRequest);
}
