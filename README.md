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

#### Optional Python Example from Square
Running Square Python example ([prerequisites](https://developer.squareup.com/docs/testing/sandbox)).

Start by cloning and installing:
```
$ git clone https://github.com/square/connect-api-examples
$ cd connect-examples/oauth/python
$ pip3 install -r requirements.txt
```

Add an optional `shutdown` function:
```
import os, signal

# Simple server shutdown command
@app.route('/shutdown', methods=['GET'])
def stopServer():
  os.kill(os.getpid(), signal.SIGINT)
  return 'Server is shutting down...'
```

Add your credentials and change the domain to the Sandbox environment:
```
$ vim oauth-flow.py # Add your credentials where REPLACE_ME is found.
$ vim oauth-flow.py # Change domain(s) to the sandbox https://connect.squareupsandbox.com along with Client environment to "sandbox".
```

Run it and visit http://localhost:5000/:
```
$ FLASK_APP=oauth-flow.py FLASK_ENV=development flask runflask run 
```
