package cigma.pfe.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    @Entity
    @Getter
    @Setter
    @ToString
    public class Promotion {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String description;
        public Promotion(String description) {
            this.description = description;
        }
    }
}
