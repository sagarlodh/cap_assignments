package com.org.bookingservice.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "database_sequences")
public class DatabaseSequence {

    /**
     * DATA
     */
    @Id
    private String id;
    private Long seq;

}
