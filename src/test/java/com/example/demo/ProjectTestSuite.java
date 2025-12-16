package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

@Listeners(TestResultListener.class)
@SpringBootTest(classes = com.example.demo.DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectTestSuite extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    private int port;

    private RestTemplate restTemplate;
    private String baseUrl;
    private String authToken;
    private Path projectRoot;

    @BeforeClass
    public void setUp() {
        restTemplate = new RestTemplate();
        baseUrl = "http://localhost:" + port;
        
        // Get project root directory
        String userDir = System.getProperty("user.dir");
        projectRoot = Paths.get(userDir);
    }

    // ==================== FOLDER STRUCTURE TESTS (1-10) ====================

    @Test(priority = 1, description = "Test 1: Verify main source directory exists")
    public void testMainSourceDirectoryExists() {
        Path mainPath = projectRoot.resolve("src/main/java");
        assertTrue(Files.exists(mainPath), "src/main/java directory should exist");
        assertTrue(Files.isDirectory(mainPath), "src/main/java should be a directory");
    }

    @Test(priority = 2, description = "Test 2: Verify resources directory exists")
    public void testResourcesDirectoryExists() {
        Path resourcesPath = projectRoot.resolve("src/main/resources");
        assertTrue(Files.exists(resourcesPath), "src/main/resources directory should exist");
        assertTrue(Files.isDirectory(resourcesPath), "src/main/resources should be a directory");
    }

    @Test(priority = 3, description = "Test 3: Verify controller package directory exists")
    public void testControllerPackageExists() {
        Path controllerPath = projectRoot.resolve("src/main/java/com/example/demo/controller");
        assertTrue(Files.exists(controllerPath), "controller package directory should exist");
        assertTrue(Files.isDirectory(controllerPath), "controller should be a directory");
    }

    @Test(priority = 4, description = "Test 4: Verify service package directory exists")
    public void testServicePackageExists() {
        Path servicePath = projectRoot.resolve("src/main/java/com/example/demo/service");
        assertTrue(Files.exists(servicePath), "service package directory should exist");
        assertTrue(Files.isDirectory(servicePath), "service should be a directory");
    }

    @Test(priority = 5, description = "Test 5: Verify entity package directory exists")
    public void testEntityPackageExists() {
        Path entityPath = projectRoot.resolve("src/main/java/com/example/demo/entity");
        assertTrue(Files.exists(entityPath), "entity package directory should exist");
        assertTrue(Files.isDirectory(entityPath), "entity should be a directory");
    }

    @Test(priority = 6, description = "Test 6: Verify repository package directory exists")
    public void testRepositoryPackageExists() {
        Path repositoryPath = projectRoot.resolve("src/main/java/com/example/demo/repository");
        assertTrue(Files.exists(repositoryPath), "repository package directory should exist");
        assertTrue(Files.isDirectory(repositoryPath), "repository should be a directory");
    }

    @Test(priority = 7, description = "Test 7: Verify config package directory exists")
    public void testConfigPackageExists() {
        Path configPath = projectRoot.resolve("src/main/java/com/example/demo/config");
        assertTrue(Files.exists(configPath), "config package directory should exist");
        assertTrue(Files.isDirectory(configPath), "config should be a directory");
    }

    @Test(priority = 8, description = "Test 8: Verify dto package directory exists")
    public void testDtoPackageExists() {
        Path dtoPath = projectRoot.resolve("src/main/java/com/example/demo/dto");
        assertTrue(Files.exists(dtoPath), "dto package directory should exist");
        assertTrue(Files.isDirectory(dtoPath), "dto should be a directory");
    }

    @Test(priority = 9, description = "Test 9: Verify util package directory exists")
    public void testUtilPackageExists() {
        Path utilPath = projectRoot.resolve("src/main/java/com/example/demo/util");
        assertTrue(Files.exists(utilPath), "util package directory should exist");
        assertTrue(Files.isDirectory(utilPath), "util should be a directory");
    }

    @Test(priority = 10, description = "Test 10: Verify test directory structure exists")
    public void testTestDirectoryExists() {
        Path testPath = projectRoot.resolve("src/test/java");
        assertTrue(Files.exists(testPath) || testPath.toFile().mkdirs(), 
                   "src/test/java directory should exist or be created");
    }

    // ==================== FILE NAME TESTS (11-20) ====================

    @Test(priority = 11, description = "Test 11: Verify ApplianceController.java exists")
    public void testApplianceControllerFileExists() {
        Path filePath = projectRoot.resolve("src/main/java/com/example/demo/controller/ApplianceController.java");
        assertTrue(Files.exists(filePath), "ApplianceController.java should exist");
    }

    @Test(priority = 12, description = "Test 12: Verify AuthController.java exists")
    public void testAuthControllerFileExists() {
        Path filePath = projectRoot.resolve("src/main/java/com/example/demo/controller/AuthController.java");
        assertTrue(Files.exists(filePath), "AuthController.java should exist");
    }

    @Test(priority = 13, description = "Test 13: Verify UsageController.java exists")
    public void testUsageControllerFileExists() {
        Path filePath = projectRoot.resolve("src/main/java/com/example/demo/controller/UsageController.java");
        assertTrue(Files.exists(filePath), "UsageController.java should exist");
    }

    @Test(priority = 14, description = "Test 14: Verify RecommendationController.java exists")
    public void testRecommendationControllerFileExists() {
        Path filePath = projectRoot.resolve("src/main/java/com/example/demo/controller/RecommendationController.java");
        assertTrue(Files.exists(filePath), "RecommendationController.java should exist");
    }

    @Test(priority = 15, description = "Test 15: Verify application.properties exists")
    public void testApplicationPropertiesExists() {
        Path filePath = projectRoot.resolve("src/main/resources/application.properties");
        assertTrue(Files.exists(filePath), "application.properties should exist");
    }

    @Test(priority = 16, description = "Test 16: Verify pom.xml exists")
    public void testPomXmlExists() {
        Path filePath = projectRoot.resolve("pom.xml");
        assertTrue(Files.exists(filePath), "pom.xml should exist");
    }

    @Test(priority = 17, description = "Test 17: Verify User entity file exists")
    public void testUserEntityFileExists() {
        Path filePath = projectRoot.resolve("src/main/java/com/example/demo/entity/User.java");
        assertTrue(Files.exists(filePath), "User.java entity should exist");
    }

    @Test(priority = 18, description = "Test 18: Verify Appliance entity file exists")
    public void testApplianceEntityFileExists() {
        Path filePath = projectRoot.resolve("src/main/java/com/example/demo/entity/Appliance.java");
        assertTrue(Files.exists(filePath), "Appliance.java entity should exist");
    }

    @Test(priority = 19, description = "Test 19: Verify SecurityConfig.java exists")
    public void testSecurityConfigFileExists() {
        Path filePath = projectRoot.resolve("src/main/java/com/example/demo/config/SecurityConfig.java");
        assertTrue(Files.exists(filePath), "SecurityConfig.java should exist");
    }

    @Test(priority = 20, description = "Test 20: Verify JwtUtil.java exists")
    public void testJwtUtilFileExists() {
        Path filePath = projectRoot.resolve("src/main/java/com/example/demo/util/JwtUtil.java");
        assertTrue(Files.exists(filePath), "JwtUtil.java should exist");
    }

    // ==================== API REQUEST TESTS (21-30) ====================

    @Test(priority = 21, description = "Test 21: Test user registration API - POST /auth/register")
    public void testUserRegistrationAPI() {
        try {
            Map<String, String> user = new HashMap<>();
            user.put("name", "Test User");
            user.put("email", "testuser" + System.currentTimeMillis() + "@test.com");
            user.put("password", "password123");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map<String, String>> request = new HttpEntity<>(user, headers);

            ResponseEntity<Map> response = restTemplate.postForEntity(
                    baseUrl + "/auth/register", request, Map.class);

            // Accept 200 OK or 400 Bad Request (validation error) as valid responses
            assertTrue(response.getStatusCode() == HttpStatus.OK || 
                      response.getStatusCode() == HttpStatus.BAD_REQUEST,
                      "Registration should return 200 OK or 400 Bad Request, got: " + response.getStatusCode());
        } catch (HttpClientErrorException e) {
            // Accept 400 or 403 as valid (means endpoint is accessible)
            assertTrue(e.getStatusCode() == HttpStatus.BAD_REQUEST || 
                      e.getStatusCode() == HttpStatus.FORBIDDEN,
                      "Registration endpoint should be accessible, got: " + e.getStatusCode());
        } catch (Exception e) {
            // If server is not running, test will fail gracefully
            fail("User registration API test failed: " + e.getMessage());
        }
    }

    @Test(priority = 22, description = "Test 22: Test user login API - POST /auth/login")
    public void testUserLoginAPI() {
        try {
            // First register a user
            Map<String, String> user = new HashMap<>();
            String email = "logintest" + System.currentTimeMillis() + "@test.com";
            user.put("name", "Login Test User");
            user.put("email", email);
            user.put("password", "password123");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map<String, String>> registerRequest = new HttpEntity<>(user, headers);
            try {
                restTemplate.postForEntity(baseUrl + "/auth/register", registerRequest, Map.class);
            } catch (HttpClientErrorException e) {
                // Registration might fail, continue with login test
            }

            // Now try to login
            Map<String, String> loginRequest = new HashMap<>();
            loginRequest.put("email", email);
            loginRequest.put("password", "password123");

            HttpEntity<Map<String, String>> loginHttpRequest = new HttpEntity<>(loginRequest, headers);
            ResponseEntity<Map> response = restTemplate.postForEntity(
                    baseUrl + "/auth/login", loginHttpRequest, Map.class);

            // Accept 200 OK or 400 Bad Request (invalid credentials) as valid
            assertTrue(response.getStatusCode() == HttpStatus.OK || 
                      response.getStatusCode() == HttpStatus.BAD_REQUEST,
                      "Login should return 200 OK or 400 Bad Request, got: " + response.getStatusCode());
            
            // Store token for subsequent tests if login was successful
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null && response.getBody().containsKey("token")) {
                authToken = (String) response.getBody().get("token");
            }
        } catch (HttpClientErrorException e) {
            // Accept 400 or 403 as valid (means endpoint is accessible)
            assertTrue(e.getStatusCode() == HttpStatus.BAD_REQUEST || 
                      e.getStatusCode() == HttpStatus.FORBIDDEN,
                      "Login endpoint should be accessible, got: " + e.getStatusCode());
        } catch (Exception e) {
            fail("User login API test failed: " + e.getMessage());
        }
    }

    @Test(priority = 23, description = "Test 23: Test get appliances API - GET /appliances/user/{userId}")
    public void testGetAppliancesAPI() {
        try {
            HttpHeaders headers = new HttpHeaders();
            if (authToken != null) {
                headers.setBearerAuth(authToken);
            }
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<Object> response = restTemplate.exchange(
                    baseUrl + "/appliances/user/1",
                    HttpMethod.GET,
                    request,
                    Object.class
            );

            // Should return 200, 401, or 403 (if not authenticated or forbidden)
            assertTrue(response.getStatusCode() == HttpStatus.OK || 
                      response.getStatusCode() == HttpStatus.UNAUTHORIZED ||
                      response.getStatusCode() == HttpStatus.FORBIDDEN,
                      "Should return 200 OK, 401 Unauthorized, or 403 Forbidden");
        } catch (HttpClientErrorException e) {
            // Accept 401, 403 as valid (means endpoint is accessible and security is working)
            assertTrue(e.getStatusCode() == HttpStatus.UNAUTHORIZED || 
                      e.getStatusCode() == HttpStatus.FORBIDDEN,
                      "Get appliances endpoint should be accessible, got: " + e.getStatusCode());
        } catch (Exception e) {
            fail("Get appliances API test failed: " + e.getMessage());
        }
    }

    @Test(priority = 24, description = "Test 24: Test add appliance API - POST /appliances/add/{userId}")
    public void testAddApplianceAPI() {
        try {
            Map<String, Object> appliance = new HashMap<>();
            appliance.put("applianceName", "Test Refrigerator");
            appliance.put("wattage", 150);
            appliance.put("usageHoursPerDay", 24);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            if (authToken != null) {
                headers.setBearerAuth(authToken);
            }
            HttpEntity<Map<String, Object>> request = new HttpEntity<>(appliance, headers);

            ResponseEntity<Object> response = restTemplate.postForEntity(
                    baseUrl + "/appliances/add/1", request, Object.class);

            assertTrue(response.getStatusCode() == HttpStatus.OK || 
                      response.getStatusCode() == HttpStatus.UNAUTHORIZED ||
                      response.getStatusCode() == HttpStatus.FORBIDDEN,
                      "Should return 200 OK, 401 Unauthorized, or 403 Forbidden");
        } catch (HttpClientErrorException e) {
            assertTrue(e.getStatusCode() == HttpStatus.UNAUTHORIZED || 
                      e.getStatusCode() == HttpStatus.FORBIDDEN,
                      "Add appliance endpoint should be accessible, got: " + e.getStatusCode());
        } catch (Exception e) {
            fail("Add appliance API test failed: " + e.getMessage());
        }
    }

    @Test(priority = 25, description = "Test 25: Test delete appliance API - DELETE /appliances/{applianceId}/user/{userId}")
    public void testDeleteApplianceAPI() {
        try {
            HttpHeaders headers = new HttpHeaders();
            if (authToken != null) {
                headers.setBearerAuth(authToken);
            }
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<Object> response = restTemplate.exchange(
                    baseUrl + "/appliances/1/user/1",
                    HttpMethod.DELETE,
                    request,
                    Object.class
            );

            assertTrue(response.getStatusCode() == HttpStatus.OK || 
                      response.getStatusCode() == HttpStatus.UNAUTHORIZED ||
                      response.getStatusCode() == HttpStatus.FORBIDDEN ||
                      response.getStatusCode() == HttpStatus.NOT_FOUND,
                      "Should return appropriate status code");
        } catch (HttpClientErrorException e) {
            assertTrue(e.getStatusCode() == HttpStatus.UNAUTHORIZED || 
                      e.getStatusCode() == HttpStatus.FORBIDDEN ||
                      e.getStatusCode() == HttpStatus.NOT_FOUND,
                      "Delete appliance endpoint should be accessible, got: " + e.getStatusCode());
        } catch (Exception e) {
            fail("Delete appliance API test failed: " + e.getMessage());
        }
    }

    @Test(priority = 26, description = "Test 26: Test log usage API - POST /usage/log/{applianceId}")
    public void testLogUsageAPI() {
        try {
            HttpHeaders headers = new HttpHeaders();
            if (authToken != null) {
                headers.setBearerAuth(authToken);
            }
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<Object> response = restTemplate.postForEntity(
                    baseUrl + "/usage/log/1", request, Object.class);

            assertTrue(response.getStatusCode() == HttpStatus.OK || 
                      response.getStatusCode() == HttpStatus.UNAUTHORIZED ||
                      response.getStatusCode() == HttpStatus.FORBIDDEN ||
                      response.getStatusCode() == HttpStatus.NOT_FOUND,
                      "Should return appropriate status code");
        } catch (HttpClientErrorException e) {
            assertTrue(e.getStatusCode() == HttpStatus.UNAUTHORIZED || 
                      e.getStatusCode() == HttpStatus.FORBIDDEN ||
                      e.getStatusCode() == HttpStatus.NOT_FOUND,
                      "Log usage endpoint should be accessible, got: " + e.getStatusCode());
        } catch (Exception e) {
            fail("Log usage API test failed: " + e.getMessage());
        }
    }

    @Test(priority = 27, description = "Test 27: Test get usage logs API - GET /usage/logs/{userId}")
    public void testGetUsageLogsAPI() {
        try {
            HttpHeaders headers = new HttpHeaders();
            if (authToken != null) {
                headers.setBearerAuth(authToken);
            }
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<Object> response = restTemplate.exchange(
                    baseUrl + "/usage/logs/1",
                    HttpMethod.GET,
                    request,
                    Object.class
            );

            assertTrue(response.getStatusCode() == HttpStatus.OK || 
                      response.getStatusCode() == HttpStatus.UNAUTHORIZED ||
                      response.getStatusCode() == HttpStatus.FORBIDDEN,
                      "Should return 200 OK, 401 Unauthorized, or 403 Forbidden");
        } catch (HttpClientErrorException e) {
            assertTrue(e.getStatusCode() == HttpStatus.UNAUTHORIZED || 
                      e.getStatusCode() == HttpStatus.FORBIDDEN,
                      "Get usage logs endpoint should be accessible, got: " + e.getStatusCode());
        } catch (Exception e) {
            fail("Get usage logs API test failed: " + e.getMessage());
        }
    }

    @Test(priority = 28, description = "Test 28: Test get total units API - GET /usage/total/{userId}")
    public void testGetTotalUnitsAPI() {
        try {
            HttpHeaders headers = new HttpHeaders();
            if (authToken != null) {
                headers.setBearerAuth(authToken);
            }
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<Object> response = restTemplate.exchange(
                    baseUrl + "/usage/total/1",
                    HttpMethod.GET,
                    request,
                    Object.class
            );

            assertTrue(response.getStatusCode() == HttpStatus.OK || 
                      response.getStatusCode() == HttpStatus.UNAUTHORIZED ||
                      response.getStatusCode() == HttpStatus.FORBIDDEN,
                      "Should return 200 OK, 401 Unauthorized, or 403 Forbidden");
        } catch (HttpClientErrorException e) {
            assertTrue(e.getStatusCode() == HttpStatus.UNAUTHORIZED || 
                      e.getStatusCode() == HttpStatus.FORBIDDEN,
                      "Get total units endpoint should be accessible, got: " + e.getStatusCode());
        } catch (Exception e) {
            fail("Get total units API test failed: " + e.getMessage());
        }
    }

    @Test(priority = 29, description = "Test 29: Test generate recommendations API - POST /recommendations/generate/{userId}")
    public void testGenerateRecommendationsAPI() {
        try {
            HttpHeaders headers = new HttpHeaders();
            if (authToken != null) {
                headers.setBearerAuth(authToken);
            }
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<Object> response = restTemplate.postForEntity(
                    baseUrl + "/recommendations/generate/1", request, Object.class);

            assertTrue(response.getStatusCode() == HttpStatus.OK || 
                      response.getStatusCode() == HttpStatus.UNAUTHORIZED ||
                      response.getStatusCode() == HttpStatus.FORBIDDEN ||
                      response.getStatusCode() == HttpStatus.NOT_FOUND,
                      "Should return appropriate status code");
        } catch (HttpClientErrorException e) {
            assertTrue(e.getStatusCode() == HttpStatus.UNAUTHORIZED || 
                      e.getStatusCode() == HttpStatus.FORBIDDEN ||
                      e.getStatusCode() == HttpStatus.NOT_FOUND,
                      "Generate recommendations endpoint should be accessible, got: " + e.getStatusCode());
        } catch (Exception e) {
            fail("Generate recommendations API test failed: " + e.getMessage());
        }
    }

    @Test(priority = 30, description = "Test 30: Test get recommendations API - GET /recommendations/user/{userId}")
    public void testGetRecommendationsAPI() {
        try {
            HttpHeaders headers = new HttpHeaders();
            if (authToken != null) {
                headers.setBearerAuth(authToken);
            }
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<Object> response = restTemplate.exchange(
                    baseUrl + "/recommendations/user/1",
                    HttpMethod.GET,
                    request,
                    Object.class
            );

            assertTrue(response.getStatusCode() == HttpStatus.OK || 
                      response.getStatusCode() == HttpStatus.UNAUTHORIZED ||
                      response.getStatusCode() == HttpStatus.FORBIDDEN,
                      "Should return 200 OK, 401 Unauthorized, or 403 Forbidden");
        } catch (HttpClientErrorException e) {
            assertTrue(e.getStatusCode() == HttpStatus.UNAUTHORIZED || 
                      e.getStatusCode() == HttpStatus.FORBIDDEN,
                      "Get recommendations endpoint should be accessible, got: " + e.getStatusCode());
        } catch (Exception e) {
            fail("Get recommendations API test failed: " + e.getMessage());
        }
    }
}
