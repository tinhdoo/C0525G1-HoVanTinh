package ss8;

public class Refactoring {
    public class CleanCode {
        public int sum(int numA, int numB, int numC) {
            return numA + numB + numC;
        }
        public class EmployeeInfor{
            private String name;
            private String age;
            private String awards;
            private String ctc;
            private String experience;
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getAwards() {
                return awards;
            }

            public void setAwards(String awards) {
                this.awards = awards;
            }

            public String getCtc() {
                return ctc;
            }

            public void setCtc(String ctc) {
                this.ctc = ctc;
            }

            public String getExperience() {
                return experience;
            }

            public void setExperience(String experience) {
                this.experience = experience;
            }

            public EmployeeInfor(String name, String age, String awards, String ctc, String experience) {
                this.name = name;
                this.age = age;
                this.awards = awards;
                this.ctc = ctc;
                this.experience = experience;
            }
        }

        private void employeeDetails(EmployeeInfor Infor) {
            // Do something
        }

        public boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        }

        public int getDayOfMonth(int month, int year) {
            return switch (month) {
                case 1, 3, 5, 7, 10, 12 -> 31;
                case 4, 6, 9, 11 -> 30;
                case 2 -> isLeapYear(year) ? 29 : 28;
                default -> -1;
            };
        }
    }
}
