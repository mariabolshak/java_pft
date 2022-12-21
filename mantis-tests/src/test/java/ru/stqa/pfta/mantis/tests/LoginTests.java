package ru.stqa.pfta.mantis.tests;

public class LoginTests extends TestBase {
    @Test
    public void testLogin() throws IOException {
        HttpSession session = app.newSession();
        assertTrue(session.login("administrator", "root"));
        assertTrue(session.isLoggedInAs("administrator"));
    }
}
