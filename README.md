
# Load-s-APIS

### Overview
This project is a Java-based API integration module that handles data loading and API requests. It includes `LoadApi.java` for managing API data loading and `ApiController.java` for client-server communication, designed for efficient fetching, processing, and integration of third-party APIs.

### Features
- **API Data Loading:** Efficient handling of data from external APIs.
- **Client-Server Communication:** `ApiController.java` manages smooth communication between the client and the server.
- **Error Handling:** Built-in mechanisms to manage API failures and errors gracefully.
- **Extensibility:** Easily adaptable for integrating additional APIs or extending functionality.

### Prerequisites
- **Java:** Version 8 or higher.
- **Maven/Gradle:** For dependency management and project building.

### Installation

#### Step-by-Step Guide:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Abhimanyu005/Load-s-APIS
   ```

2. **Navigate to the project directory:**

   ```bash
   cd Load-s-APIS
   ```

3. **Build the project:**

   - Using Maven:

     ```bash
     mvn clean install
     ```

   - Using Gradle:

     ```bash
     gradle build
     ```

### API Endpoints

#### POST `/load`
- **Description:** Adds new load data to the system.
- **Payload Example:**
  
  ```json
  {
    "loadingPoint": "delhi",
    "unloadingPoint": "jaipur",
    "productType": "chemicals",
    "truckType": "canter",
    "noOfTrucks": "1",
    "weight": "100",
    "comment": "",
    "shipperId": "shipper:<UUID>",
    "Date": "dd-mm-yyyy"
  }
  ```
- **Response:** `"Load details added successfully"`

#### GET `/load`
- **Description:** Retrieves a list of loads based on the `shipperId`.
- **Query Params:** `shipperId`
- **Response:** List of loads associated with the given `shipperId`

#### GET `/load/{loadId}`
- **Description:** Retrieves the details of a specific load.
- **Response:** Details of the load associated with the given `loadId`

#### PUT `/load/{loadId}`
- **Description:** Updates existing load data in the system.
- **Payload Example:**

  ```json
  {
    "loadingPoint": "alwar",
    "unloadingPoint": "jaipur",
    "productType": "chemicals",
    "truckType": "canter",
    "noOfTrucks": "1",
    "weight": "100",
    "comment": "",
    "Date": "dd-mm-yyyy"
  }
  ```
- **Response:** `"Load details updated successfully"`

#### DELETE `/load/{loadId}`
- **Description:** Deletes a specific load based on the `loadId`.
- **Response:** `"Load deleted successfully"`

#### PUT `/api/data`
- **Description:** Updates existing data in the system.

#### DELETE `/api/data/{id}`
- **Description:** Deletes a specific piece of data based on the ID.

### License
This project is licensed under the MIT License.
