link for angular guide :

https://www.youtube.com/watch?v=0eWrpsCLMJQ&list=PLC3y8-rFHvwhBRAgFinJR8KHIrCdTkZcZ

# Http :

    used to make an http call to backend and get a response

# Observables:

    the response returned by http calls are Observables.
    or http response that arrive asynchronously

![Alt text](./img.png?raw=true 'Title')

# Understanding observables:

![Alt text](./img2.png?raw=true 'Title')

    Here the newspaper company is getting content from source
    Content may be a single paragraph
    News paper company needs to convert the content into required format
    For example here it needs to "map" the information in Headline , body , images and so on.
    Then it needs to send the newspaper to designated houses but hang on ,
    It delivers newspapers to only those houses which are subscribed for newspaper.

# RxJs:
    reactive extensions for Javasccript
    External library to work with observables.

    var observables = Rx.Observables.create( o=>{
        o.next('Some value');
        o.error('Something went wrong');
        o.complete('All done');
    });

    observable.subscribe(
        value => console.log(value);
        errro => console.log('error' + error);
        _ => console.log('All Done');
    );

    note : add the script for rxjs also 
# Promise

    var promise = new Promise((resolve, error) => {
        // its the producer code 
    });

    promise.then(() => {
        // its the consumer code 
    });

# Promise vs Observable

    promise is single value
    observable is a stream of data emitting asynchronously.

![Alt text](./img3.png?raw=true 'Title')

![Alt text](./img4.png?raw=true 'Title')

![Alt text](./img5.png?raw=true 'Title')

![Alt text](./img6.png?raw=true 'Title')
