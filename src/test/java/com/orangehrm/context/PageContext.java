package com.orangehrm.context;

import com.orangehrm.pages.pageobjects.dashboard.DashboardPO;
import com.orangehrm.pages.pageobjects.pim.AddEmployeePO;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import com.orangehrm.pages.pageobjects.pim.PersonalDetailsPO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageContext {
    private DashboardPO dashboardPage;
    private PersonalDetailsPO personalDetailsPage;
    private EmployeeListPO employeeListPage;
    private AddEmployeePO addEmployeePage;

}
