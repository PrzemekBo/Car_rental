package com.capgemini.aWyw;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessionDTO {


    private Long id;
    private String professionName;


    public static ProfessionDTO.ProfessionDTOBuilder builder() {
        return new ProfessionDTO.ProfessionDTOBuilder();
    }



    public static class ProfessionDTOBuilder {

        private Long id;
        private String professionName;

        public ProfessionDTOBuilder() {
        }


            public ProfessionDTOBuilder withId(Long id) {
                this.id = id;
                return this;
            }

            public ProfessionDTOBuilder withProfessionName(String professionName) {
                this.professionName = professionName;
                return this;
            }

        public ProfessionDTO build() {
            return new ProfessionDTO(id, professionName);
        }

        }
    }

