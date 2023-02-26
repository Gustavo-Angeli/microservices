package com.gusta.cambioservice.repository;

import com.gusta.cambioservice.model.entity.*;
import org.springframework.data.jpa.repository.*;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

    Cambio findByFromAndTo(String from, String to);

}
