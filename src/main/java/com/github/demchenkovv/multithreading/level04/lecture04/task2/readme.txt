// Реализация метода someAction анонимного класса Action поля solutionAction от JR

    private Action solutionAction = new Action() {
        private FirstClass first;
        private SecondClass second;

        public void someAction() {
            if (param > 0) {
                if (first == null) {
                    first = new FirstClass() {
                        @Override
                        public void someAction() {
                            super.someAction();
                            Solution.this.someAction();
                        }

                        @Override
                        public Action getDependantAction() {
                            System.out.println(param);
                            param--;
                            return param > 0 ? Solution.this : this;
                        }
                    };
                }
                first.getDependantAction().someAction();
            } else {
                if (second == null) {
                    second = new SecondClass() {
                        @Override
                        public void someAction() {
                            sb.append(SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM).append(param);
                            super.someAction();

                        }
                    };
                }
                second.someAction();
            }
        }
    };