import React, { useState } from 'react';
import axios from 'axios';

const FoundationForm = () => {
  const [email, setEmail] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/foundations', { email });
      alert('Foundation created successfully!');
      // Reset form field after successful submission
      setEmail('');
    } catch (error) {
      console.error('Error creating foundation:', error);
      alert('Failed to create foundation. Please try again.');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Email:
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
};

export default FoundationForm;
