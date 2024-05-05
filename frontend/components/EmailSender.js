import React, { useState } from 'react';
import axios from 'axios';

const EmailSender = () => {
  const [nonprofits, setNonprofits] = useState([]);
  const [selectedNonprofits, setSelectedNonprofits] = useState([]);
  const [emailBody, setEmailBody] = useState('');

  const handleNonprofitChange = (e, nonprofit) => {
    if (e.target.checked) {
      setSelectedNonprofits([...selectedNonprofits, nonprofit]);
    } else {
      setSelectedNonprofits(selectedNonprofits.filter((item) => item !== nonprofit));
    }
  };

  const handleSendEmail = async () => {
    try {
      await axios.post('http://localhost:8080/emails/send', selectedNonprofits, {
        headers: {
          'Content-Type': 'application/json',
        },
        data: { emailBody },
      });
      alert('Emails sent successfully!');
    } catch (error) {
      console.error('Error sending emails:', error);
      alert('Failed to send emails. Please try again.');
    }
  };

  const handleLoadNonprofits = async () => {
    try {
      const response = await axios.get('http://localhost:8080/nonprofits');
      setNonprofits(response.data);
    } catch (error) {
      console.error('Error loading nonprofits:', error);
      alert('Failed to load nonprofits. Please try again.');
    }
  };

  return (
    <div>
      <button onClick={handleLoadNonprofits}>Load Nonprofits</button>
      <div>
        {nonprofits.map((nonprofit) => (
          <label key={nonprofit.id}>
            <input
              type="checkbox"
              onChange={(e) => handleNonprofitChange(e, nonprofit)}
            />
            {nonprofit.name} - {nonprofit.address}
          </label>
        ))}
      </div>
      <textarea value={emailBody} onChange={(e) => setEmailBody(e.target.value)} />
      <button onClick={handleSendEmail}>Send Emails</button>
    </div>
  );
};

export default EmailSender;
