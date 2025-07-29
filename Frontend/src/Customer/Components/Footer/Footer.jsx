import React from "react";
import { Grid, Typography, Box, Link, Container } from "@mui/material";

const footerData = [
  {
    title: "Company",
    links: ["About", "Blog", "Jobs", "Press", "Partners"],
  },
  {
    title: "Solutions",
    links: ["Marketing", "Analytics", "Commerce", "Insights", "Support"],
  },
  {
    title: "Documentation",
    links: ["Guides", "API Status"],
  },
  {
    title: "Legal",
    links: ["Claim", "Privacy", "Terms"],
  },
];

const Footer = () => {
  return (
    <Box sx={{ bgcolor: "black", color: "white", mt: 10, py: 6 }}>
      <Container maxWidth="lg">
        <Grid container spacing={4} justifyContent="space-between">
          {footerData.map((section) => (
            <Grid item xs={12} sm={6} md={3} key={section.title}>
              <Typography variant="h6" gutterBottom sx={{ fontWeight: "bold" }}>
                {section.title}
              </Typography>
              {section.links.map((link) => (
                <Typography
                  key={link}
                  variant="body2"
                  sx={{ mt: 1, cursor: "pointer" }}
                >
                  {link}
                </Typography>
              ))}
            </Grid>
          ))}
        </Grid>

        <Box
          sx={{
            textAlign: "center",
            mt: 6,
            fontSize: "0.85rem",
            color: "#ccc",
          }}
        >
          © 2023 My Company. All rights reserved.
          <br />
          Made with love by Me. <br />
          Icons made by Freepik from{" "}
          <Link
            href="https://www.flaticon.com"
            target="_blank"
            rel="noopener noreferrer"
            sx={{ color: "#ffffff", textDecoration: "underline" }}
          >
            www.flaticon.com
          </Link>
        </Box>
      </Container>
    </Box>
  );
};

export default Footer;
