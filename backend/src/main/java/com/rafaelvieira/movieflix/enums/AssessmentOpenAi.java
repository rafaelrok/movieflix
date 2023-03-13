package com.rafaelvieira.movieflix.enums;

public enum AssessmentOpenAi {

    COMMENT_RATING {
        @Override
        public String toString() {
            return "Avalie o sentimento nesse comentário com uma nota de 0.0(Negativo) a 5.0(Positivo). Comentário: ";
        }
    }

}
