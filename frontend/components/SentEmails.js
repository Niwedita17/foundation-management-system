import React, { useState, useEffect } from 'react';
import axios from 'axios';

const SentEmails = () => {
  const [emails, setEmails] = useState([]);

  useEffect(() => {
    const fetchEmails = async () => {
      try {
        const response = await axios.get('http://localhost:8080/emails');
        setEmails(response.data);
      } catch (error) {
        console.error('Error loading sent emails:', error);
        alert('Failed to load sent emails. Please try again.');
      }
    };
    fetchEmails();
  }, []);

  return (
    <div>
      <ul>
        {emails.map((email, index) => (
          <li key={index}>{email}</li>
        ))}
      </ul>
    </div>
  );
};

export default SentEmails;
