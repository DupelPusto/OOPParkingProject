package project.staff;

public class Salary {
    protected static double securitySalaryRate = 18300;
    protected static double cleanerSalaryRate = 17600;
    private static final double YEAR_SUPPLEMENT = 0.003;
    private static final double FINAL_SUPPLEMENT = 0.006;
    private static final int MAX_YEAR_FOR_SUPP = 6;


    /*
    Salary computing logic:
    If person`s experience less or equals 6 years, the next formula is used:
    (experience * year_supplement) * salary_rate(is depending of person staff_kind) + salary_rate

    If person`s experience more than 6 years, the next formula is used:
    ((max_year_for_supplement * year_supplement) + (final_supplement * 7)) *
     * salary_rate(is depending of person staff_kind) + salary_rate
     */
    private static double computeSupplement(int exp){
        double res = 0;
        if(exp <= MAX_YEAR_FOR_SUPP){
            res = exp * YEAR_SUPPLEMENT;
        }

        if(exp > MAX_YEAR_FOR_SUPP){
            if(exp - MAX_YEAR_FOR_SUPP >= 0){
                res = (MAX_YEAR_FOR_SUPP * YEAR_SUPPLEMENT) + (7 * FINAL_SUPPLEMENT);
            }
        }
        return res;
    }


    public static String computeSalary(Staff s){
        double salary = 0;
        if(s.getCategory().equals("Secure staff")){
            salary = (computeSupplement(s.getWorkExperience()) * securitySalaryRate) + securitySalaryRate;
        }

        if (s.getCategory().equals("Cleaning staff")){
            salary = (computeSupplement(s.getWorkExperience()) * cleanerSalaryRate) + cleanerSalaryRate;
        }
        return String.format("For %s %s %s month salary is %.3f UAH", s.getWorkPosition(), s.getName(), s.getSurname(), salary);
    }


}
