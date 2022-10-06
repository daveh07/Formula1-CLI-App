# Formula1-CLI-App
A CLI application written in Java to retrieve Formula 1 data from the F1 API - Ergast Developer API 

### SETUP
> Clone the repository: https://github.com/daveh07/Formula1-CLI-App.git
> Project is written in Java 17
> Run Maven dependencies
> In src folder, run App.Java. This is the main class for the program

### NOTES:
> The purpose of the CLI application is to quickly access historical data from formula seasons and return a data array with results fetched from the F1 API: https://documenter.getpostman.com/view/11586746/SztEa7bL
> Current data returns a XML object. 
> To return a JSON string, apend .JSON to the end of the relevant URL. Eg). final String POSTS_CIRC_API_URL = ("http://ergast.com/api/f1/2019/circuits.JSON");

### FURTHER FEATURES TO BE ADDED:
<li>Parsing the JSON data and formatting the object to be easily read</li>
<li>Testing modules using Junit</li>
<li>An option to storing selected data to a database</li>
<li>Sending retrieved data ti a CSV file</li>
