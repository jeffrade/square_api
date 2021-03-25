## square-api

#### Example Rust application for using Square's Payments API

You will need to register and create your own Square Developer Account to generate your OAuth credentials. To do that, start [here](https://docs.connect.squareup.com/basics/oauth/setup#prerequisites).

Be sure to export your credentials and secrets from Square ([prerequisites](https://developer.squareup.com/docs/testing/sandbox)):
```
export SQUAREUP_APP_NAME=<your-value-here>
export SQUAREUP_API_APP_ID=<your-value-here>
export SQUAREUP_API_ACC_TOKEN=<your-value-here>
export SQUAREUP_API_APP_SECRET=<your-value-here>
export SQUAREUP_OAUTH_AUTH_REQUEST=https://connect.squareupsandbox.com/oauth2/authorize?client_id=
```

### Building
```
$ cargo build
```

### Running

```
$ cargo run login
```
