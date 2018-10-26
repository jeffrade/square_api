square-api

You will need to register and create your own Square Developer Account to generate your OAuth credentials. To do that, start [here](https://docs.connect.squareup.com/basics/oauth/setup#prerequisites).

Before starting the app, export your credentials and secrets from Square:

```
export SQUAREUP_APP_NAME=<your-value-here>
export SQUAREUP_API_APP_ID=<your-value-here>
export SQUAREUP_API_ACC_TOKEN=<your-value-here>
export SQUAREUP_API_APP_SECRET=<your-value-here>
```

Micro-service for using Square's Payments API

Building:
```
$ gradle clean build
```

Running:
```
$ java -jar build/libs/square_api.jar 
```
