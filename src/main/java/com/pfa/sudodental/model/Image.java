package com.pfa.sudodental.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@Data
@NoArgsConstructor
public class Image extends  AbstractModel<Long>{
        private Long consultationId;
        private String fileName;
        private String fileType;
        @Lob
        private byte[] data;

    }


