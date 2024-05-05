import React from 'react';
import NonprofitForm from '../components/NonprofitForm';
import FoundationForm from '../components/FoundationForm';
import EmailSender from '../components/EmailSender';
import SentEmails from '../components/SentEmails';

const App = () => {
  return (
    <div>
      <h1>Foundation Management System</h1>
      <h2>Create Nonprofit</h2>
      <NonprofitForm />
      <h2>Create Foundation</h2>
      <FoundationForm />
      <h2>Send Emails</h2>
      <EmailSender />
      <h2>Sent Emails</h2>
      <SentEmails />
    </div>
  );
};

export default App;
