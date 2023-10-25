package Instructions;

public enum ComparisonOperator {
    EQUAL{
        @Override
        boolean compare(int a, int b) {
            return a == b;
        }
        @Override
        public String toString(){
            return "==";
        }
    }, NOT_EQUAL {
        @Override
        boolean compare(int a, int b) {
            return a != b;
        }
        @Override
        public String toString(){
            return "!=";
        }
    }, LESS_THAN {
        @Override
        boolean compare(int a, int b) {
            return a < b;
        }
        @Override
        public String toString(){
            return "<";
        }
    }, GREATER_THAN {
        @Override
        boolean compare(int a, int b) {
            return a > b;
        }
        @Override
        public String toString(){
            return ">";
        }
    }, LESS_THAN_OR_EQUAL {
        @Override
        boolean compare(int a, int b) {
            return a <= b;
        }
        @Override
        public String toString(){
            return "<=";
        }
    }, GREATER_THAN_OR_EQUAL {
        @Override
        boolean compare(int a, int b) {
            return a >= b;
        }
        @Override
        public String toString(){
            return ">=";
        }
    };

    abstract boolean compare(int a, int b);
}
