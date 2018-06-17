gapi.load('auth2', function() {
    auth2 = gapi.auth2.init({
        client_id: '295437875340-3h7ue0kur86lsekmi3tj3fit8qe87gbn.apps.googleusercontent.com',
        fetch_basic_profile: false,
        scope: 'profile'
    });

    // Sign the user in, and then retrieve their ID.
    auth2.signIn().then(function() {
        console.log(auth2.currentUser.get().getId());
        window.location = '/';
    });
});