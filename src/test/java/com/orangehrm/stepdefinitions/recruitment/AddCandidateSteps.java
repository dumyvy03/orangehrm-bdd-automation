package com.orangehrm.stepdefinitions.recruitment;

import com.orangehrm.commons.DriverFactory;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.recruitment.AddCandidatePO;
import com.orangehrm.pages.pageobjects.recruitment.CandidateProfilePO;
import com.orangehrm.pages.pageobjects.recruitment.CandidatesPO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class AddCandidateSteps {
    private final WebDriver driver;
    private CandidatesPO candidatePage;
    private AddCandidatePO addCandidatePage;
    private String firstName, lastName, email, contactNumber, resume, vacancy, keywords, dateOfApplication, notes;
    private CandidateProfilePO candidateProfilePage;

    public AddCandidateSteps() {
        driver = DriverFactory.getDriver();
    }

    @And("navigates to the Candidate page")
    public void navigatesToCandidatePage() {
        candidatePage = PageGenerator.getSidebarPage(driver).openRecruitmentPage();
    }

    @And("clicks the Add button to open the Add Candidate page")
    public void clicksTheAddButtonToOpenTheAddCandidatePage() {
        addCandidatePage = candidatePage.clickAddButton();
    }

    @And("the admin enters candidate information")
    public void entersCandidateInformation(DataTable dataTable) {
        Map<String, String> addCandidateData = dataTable.asMap(String.class, String.class);
        firstName = addCandidateData.get("First Name");
        lastName = addCandidateData.get("Last Name");
        vacancy = addCandidateData.get("Vacancy");
        email = addCandidateData.get("Email");
        contactNumber = addCandidateData.get("Contact Number");
        resume = addCandidateData.get("Resume");
        keywords = addCandidateData.get("Keywords");
        notes = addCandidateData.get("Notes");

        addCandidatePage.enterCandidateInformation(addCandidateData);

    }

    @And("clicks the Save button to add a new candidate")
    public void clicksTheSaveButtonToAddANewCandidate() {
        dateOfApplication = addCandidatePage.getDateOfApplicationValue();
        candidateProfilePage = addCandidatePage.clickSaveButton();
    }

    @Then("the Candidate Profile page displays the candidate’s details")
    public void verifyCandidateProfilePageDisplaysTheCandidateSDetails() {
        Assert.assertEquals(candidateProfilePage.getFirstNameValue(), firstName);
        Assert.assertEquals(candidateProfilePage.getLastNameValue(), lastName);
        Assert.assertEquals(candidateProfilePage.getJobVacancyText(), vacancy);
        Assert.assertEquals(candidateProfilePage.getEmailValue(), email);
        Assert.assertEquals(candidateProfilePage.getContactNumberValue(), contactNumber);
        Assert.assertEquals(candidateProfilePage.getUploadedResumeFileName(), resume);
        Assert.assertEquals(candidateProfilePage.getKeywordsValue(), keywords);
        Assert.assertEquals(candidateProfilePage.getDateOfApplicationValue(), dateOfApplication);
        Assert.assertEquals(candidateProfilePage.getNotesValue(), notes);
    }


    @When("the admin enters email {string}")
    public void entersEmail(String email) {
        addCandidatePage.enterEmailTextbox(email);
    }

    @Then("the email field shows error {string}")
    public void verifyEmailFieldShowsError(String errorMessage) {
        Assert.assertEquals(addCandidatePage.getEmailErrorMessage(), errorMessage);
    }

    @When("the admin uploads resume file {string}")
    public void uploadsResumeFile(String resume) {
        addCandidatePage.uploadResumeFile(resume);
    }

    @Then("the resume field shows error {string}")
    public void theResumeFieldShowsError(String errorMessage) {
        Assert.assertEquals(addCandidatePage.getResumeErrorMessage(), errorMessage);
    }

    @When("the admin enters contact number {string}")
    public void theAdminEntersContactNumber(String contactNumber) {
        addCandidatePage.enterContactNumberTextbox(contactNumber);
    }

    @Then("the contact number field shows error {string}")
    public void theContactNumberFieldShowsError(String errorMessage) {
        Assert.assertEquals(addCandidatePage.getContactNumberErrorMessage(), errorMessage);
    }


}
