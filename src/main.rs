#![allow(unused_imports)]
use clap::{App, Arg, SubCommand};
use tiny_http::{Response, Server};
use url::{ParseError, Url};

use std::env;
use std::process::Command;
use std::thread;

fn main() {
    let matches = clap::App::new("square_api_cli")
        .version("0.1.0")
        .author("Jeff Rade <jeffrade@gmail.com>")
        .about("Simple OAuth command line tool for SquareUp")
        .subcommand(
            clap::SubCommand::with_name("login")
                .about("Psuedo login to launch Square's Python app to handle OAuth callback."),
        )
        .get_matches();

    if matches.subcommand_matches("login").is_some() {
        println!("Login in progress...");
        // If needed, add initial user authentication happens here,
        // but we're requesting an authenticated web browser session instead.

        println!("Starting OAuth client server...");
        let server = Server::http("0.0.0.0:5000").unwrap();
        let authorzie_request_url =
            String::from(env!("SQUAREUP_OAUTH_AUTH_REQUEST")) + env!("SQUAREUP_API_APP_ID");
        println!(
            "Waiting for user to be authorized, visit {}",
            authorzie_request_url
        );
        listen(server);
    } else {
        println!("You must pass a valid command!");
    }
}

fn listen(server: Server) {
    for request in server.incoming_requests() {
        if request.url().starts_with("/callback?") {
            let request_url = "http://localhost:5000".to_string() + request.url();
            let callback_url = Url::parse(&request_url).expect("Could not parse callback url");
            let query = callback_url
                .query()
                .expect("Could not parse query part of callback url");
            if let Some(code_kv) = query.split('&').collect::<Vec<&str>>().first() {
                if let Some(code) = code_kv.split('=').collect::<Vec<&str>>().last() {
                    println!(
                        "User successfully authorized, authorization code is {:?}",
                        &code
                    );
                }
            }
        } else {
            println!("Unexpected request made: {:?}", request.url());
        }
    }
}
