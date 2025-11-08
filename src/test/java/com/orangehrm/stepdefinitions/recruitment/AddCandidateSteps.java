package com.orangehrm.stepdefinitions.recruitment;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.context.TestContext;
import com.orangehrm.pages.pageobjects.recruitment.AddCandidatePO;
import com.orangehrm.pages.pageobjects.recruitment.CandidateProfilePO;
import com.orangehrm.pages.pageobjects.recruitment.CandidatesPO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class AddCandidateSteps {
    private final TestContext testContext;
    private CandidatesPO candidatePage;
    private AddCandidatePO addCandidatePage;
    private String firstName, lastName, email, contactNumber, resume, vacancy, keywords, dateOfApplication, notes;
    private CandidateProfilePO candidateProfilePage;

    public AddCandidateSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("navigates to the Candidate page")
    public void navigatesToCandidatePage() {
        candidatePage = PageGenerator.getSidebarPage(testContext.getDriver()).openRecruitmentPage();
    }

    @When("the admin clicks the Add button to open the Add Candidate form")
    public void theAdminClicksTheAddButtonToOpenTheAddCandidateForm() {
        addCandidatePage = candidatePage.clickAddButton();
    }

    @And("enters candidate information")
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


    @When("the admin enters first name {string} last name {string} and email {string}")
    public void entersFirstNameLastNameAndEmail(String firstName, String lastName, String email) {
        addCandidatePage.enterFirstNameTextbox(firstName);
        addCandidatePage.enterLastNameTextbox(lastName);
        addCandidatePage.enterEmailTextbox(email);
    }

    @Then("the email field shows error {string}")
    public void verifyEmailFieldShowsError(String errorMessage) {
        Assert.assertEquals(addCandidatePage.getEmailErrorMessage(), errorMessage);
    }

    @And("uploads resume file {string}")
    public void uploadsResumeFile(String resume) {
        addCandidatePage.uploadResumeFile(resume);
    }

    @Then("the resume field shows error {string}")
    public void theResumeFieldShowsError(String errorMessage) {
        Assert.assertEquals(addCandidatePage.getResumeErrorMessage(), errorMessage);
    }

    @When("the admin enters basic candidate details")
    public void theAdminEntersBasicCandidateDetails(DataTable dataTable) {
        Map<String, String> basicCandidateData = dataTable.asMap(String.class, String.class);
        addCandidatePage.enterFirstNameTextbox(basicCandidateData.get("First Name"));
        addCandidatePage.enterLastNameTextbox(basicCandidateData.get("Last Name"));
        addCandidatePage.enterEmailTextbox(basicCandidateData.get("Email"));
        addCandidatePage.enterContactNumberTextbox(basicCandidateData.get("Contact Number"));

    }

    @Then("the contact number field shows error {string}")
    public void theContactNumberFieldShowsError(String errorMessage) {
        Assert.assertEquals(addCandidatePage.getContactNumberErrorMessage(), errorMessage);
    }
}
